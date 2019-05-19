import React, {Component} from 'react';

class UserForm extends Component {

    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const data = new FormData(event.target);

        var url = 'http://localhost:9000/users';

        fetch(url, {
            method: 'POST',
            body: data,
        });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label htmlFor="name">Name</label>
                <input id="name" name="name" type="text" required={true} />

                <label htmlFor="password">Password</label>
                <input id="password" name="password" type="password" />

                <label htmlFor="email">Email</label>
                <input id="email" name="email" type="email" />

                <label htmlFor="country">Country</label>
                <input id="country" name="country" type="text" />

                <label htmlFor="street">Street</label>
                <input id="street" name="street" type="text" />

                <label htmlFor="city">City</label>
                <input id="city" name="city" type="text" />

                <label htmlFor="address">Address</label>
                <input id="address" name="address" type="text" />

                <label htmlFor="postal">Postal</label>
                <input id="postal" name="postal" type="text" />

                <button>Add user</button>
            </form>
        );
    }

}


export default UserForm;