import React, {Component} from 'react';

class OrderForm extends Component {

    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const data = new FormData(event.target);

        var url = 'http://localhost:9000/orders';

        fetch(url, {
            method: 'POST',
            body: data,
        });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label htmlFor="user_id">User id</label>
                <input id="user_id" name="user_id" type="number" />

                <label htmlFor="order_date">Order date</label>
                <input id="order_date" name="order_date" type="text" />

                <label htmlFor="order_address">Order address</label>
                <input id="order_address" name="order_address" type="text" />

                <button>Add order</button>
            </form>
        );
    }

}


export default OrderForm;