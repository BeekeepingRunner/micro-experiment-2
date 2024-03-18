import http from 'k6/http';
import { check, sleep } from 'k6';
import { SharedArray } from 'k6/data';

export const options = {
    stages: [
        { duration: '5s', target: 300 }, // ramp up to 200 users
        { duration: '120s', target: 300 }, // stable
        { duration: '5s', target: 0 }    // ramp-down
    ]
}

const URLS = {
    Product: 'http://localhost:80/products',
    Order: 'http://localhost:80/orders',
}

// get product, submit order, get order details
export default () => {
    const productId = Math.floor(Math.random() * 10000);
    const productResponse = http.get(URLS.Product + `/${productId}`);
    if (productResponse.status == 200) {
        sleep(2);
        submitOrder(productResponse);
    }
    sleep(1);
};

const postHeaders = { 'Content-Type': 'application/json' }; 

function submitOrder (productResponse) {
    const repsonseBody = JSON.parse(productResponse.body);
    const productId = repsonseBody.id;
    const orderReqBody = {
        customerId: 1,
        productId: productId,
        quantity: Math.floor(Math.random() * 5)
    };

    http.post(URLS.Order, JSON.stringify(orderReqBody), { headers: postHeaders });
}