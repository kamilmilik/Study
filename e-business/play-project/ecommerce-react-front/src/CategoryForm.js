import React, {Component} from 'react';

class CategoryForm extends Component {

    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const data = new FormData(event.target);

        var url = 'http://localhost:9000/categories';

        fetch(url, {
            method: 'POST',
            body: data,
        });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label htmlFor="name">Category name</label>
                 {/*name musi byc taki sam jak w parametr w poscie*/}
                <input id="name" name="name" type="text" />

                <button>Add category</button>
            </form>
        );
    }

}


export default CategoryForm;