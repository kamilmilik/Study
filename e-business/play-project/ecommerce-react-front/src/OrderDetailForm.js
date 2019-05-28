import React, {Component} from 'react';

class OrderDetailForm extends Component {

    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const data = new FormData(event.target);

        var url = 'http://localhost:9000/ordersDetail';

        fetch(url, {
            method: 'POST',
            body: data,
        });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label htmlFor="order_id">Order id</label>
                <input id="order_id" name="order_id" type="number" />

                <label htmlFor="product_id">Product id</label>
                <input id="product_id" name="product_id" type="number" />

                <label htmlFor="order_product_quantity">Order product quantity</label>
                <input id="order_product_quantity" name="order_product_quantity" type="number" />

                <button>Add order detail</button>
            </form>
        );
    }

}


export default OrderDetailForm;