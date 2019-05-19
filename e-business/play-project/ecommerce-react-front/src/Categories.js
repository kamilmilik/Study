import React, {Component} from 'react';

class Categories extends Component {

    constructor() {
        super();
        this.state = {
            categories: [],
        };
    }

    componentDidMount() {
        var url = "http://localhost:9000/categories";

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
            let categories = data.map((category) => {
                return (
                    <div key={category.id}>
                        <div>{category.name}</div>
                    </div>
                )
            });
            this.setState({categories: categories})
        })
    }

    render() {
        return (
            <div className="categories">
                {this.state.categories}
            </div>
        )
    }
}

export default Categories;