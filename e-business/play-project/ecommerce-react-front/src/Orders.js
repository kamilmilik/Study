import React, {Component} from 'react';

class Orders extends Component {

    constructor() {
        super();
        this.state = {
            orders: [],
        };
    }

    componentDidMount() {
        var url = "http://localhost:9000/orders";

        fetch(url, {
            mode: 'cors',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'http://localhost:3000',
            },
            method: 'GET',
        })
            .then(results => {
                return results.json();
            }).then(data => {
            let orders = data.map((order) => {
                return (
                    <div key={order.id}>
                        <div>{order.dateTime}</div>
                    </div>
                )
            });
            this.setState({categories: orders})
        })
    }

    render() {
        return (
            <div className="orders">
                {this.state.categories}
            </div>
        )
    }
}

export default Orders;