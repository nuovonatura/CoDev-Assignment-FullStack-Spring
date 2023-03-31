import React, { createElement, useState } from "react";
import "../styles/ResultHolder.css"
import BookItem from "./BookItem";

export default function ResultHolder(props) {
    const { data } = props;
    const [ openID, setOpenID ] = useState(0);
    const bookItems = [];

    const handleToggleClick = (id) => {
        setOpenID(id);
    }

    if (data == null) {
        const errorMessage = <div id="error-message">No data found</div>;
        return (<div className="container">{errorMessage}</div>);
    } else {
        let i = 1;
        const books = data.map((item) => {
            bookItems.push(<BookItem id={i++} name={item.name} author={item.author} people={item.borrower} onToggleClick={handleToggleClick} expanded={openID}/>);
            return bookItems[bookItems.length - 1];
        })

        return (
            <div className="box" id="container">{books}</div>
        );
    }
}