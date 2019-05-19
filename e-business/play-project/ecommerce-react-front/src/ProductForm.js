import React, {Component} from 'react';

class ProductForm extends Component {

    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const data = new FormData(event.target);

        var url = 'http://localhost:9000/products';

        fetch(url, {
            method: 'POST',
            body: data,
        });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label htmlFor="name">Product name</label>
                <input id="name" name="name" type="text" />

                <label htmlFor="description">Description</label>
                <input id="description" name="description" type="text" />

                <label htmlFor="price">Price</label>
                <input id="price" name="price" type="number" />

                <label htmlFor="unavailable">Unavailable</label>
                <input id="unavailable" name="unavailable" type="text" />

                <label htmlFor="category">Category</label>
                <input id="category" name="category" type="number" />

                <button>Add product</button>
            </form>
        );
    }

}


export default ProductForm;