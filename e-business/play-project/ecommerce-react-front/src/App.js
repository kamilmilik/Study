import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';


import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom';
import Users from './Users'
import Products from './Products'
import Orders from "./Orders";
import Categories from "./Categories";
import ProductForm from "./ProductForm";
import OrderForm from "./OrderForm";
import CategoryForm from "./CategoryForm";
import UserForm from "./UserForm";

class App extends Component {
    render() {
        return <Router>
            <div id="menu">
                <ul>
                    <li>
                        <Link to="/users">Users</Link>
                    </li>
                    <li>
                        <Link to="/products">Products</Link>
                    </li>
                    <li>
                        <Link to="/orders">Orders</Link>
                    </li>
                    <li>
                        <Link to="/categories">Categories</Link>
                    </li>
                    <li>
                        <Link to="/add_product">Add Product</Link>
                    </li>
                    <li>
                        <Link to="/add_order">Add Order</Link>
                    </li>
                    <li>
                        <Link to="/add_category">Add Category</Link>
                    </li>
                    <li>
                        <Link to="/registration">Register new user</Link>
                    </li>
                </ul>
                <Route path="/users" component={Users}/>
                <Route path="/products" component={Products}/>
                <Route path="/orders" component={Orders}/>
                <Route path="/categories" component={Categories}/>
                <Route path="/add_product" component={ProductForm}/>
                <Route path="/add_order" component={OrderForm}/>
                <Route path="/add_category" component={CategoryForm}/>
                <Route path="/registration" component={UserForm}/>
            </div>
        </Router>
    }
}

export default App;
