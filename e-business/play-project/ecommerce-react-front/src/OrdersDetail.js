import React, {Component} from 'react';

class OrdersDetail extends Component {

    constructor() {
        super();
        this.state = {
            ordersDetail: [],
        };
    }

    componentDidMount() {
        var url = "http://localhost:9000/ordersDetail";

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
            let ordersDetail = data.map((orderDetail) => {
                return (
                    <div key={orderDetail.id}>
                        <div>{orderDetail.orderId}</div>
                        <div>{orderDetail.productId}</div>
                        <div>{orderDetail.orderProductQuantity}</div>
                    </div>
                )
            });
            this.setState({ordersDetail: ordersDetail})
        })
    }

    render() {
        return (
            <div className="ordersDetail">
                {this.state.ordersDetail}
            </div>
        )
    }
}

export default OrdersDetail;