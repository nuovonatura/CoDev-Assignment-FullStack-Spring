import React, { createElement, useState, useRef, useEffect } from "react";
import "../styles/BookItem.css";
import PersonItem from "./PersonItem";
import toggle from "../down.svg";

export default function BookItem(props) {
    const { id, author, name, people, expanded, onToggleClick } = props;
    const [isOpen, setIsOpen] = useState(expanded);
    const bookId = "book-item-" + id;
    const bookHolderId = "book-item-holder-" + id;
    const authorHolder = <div className="author">by {author}</div>;
    const nameHolder = <div className="info">{name}</div>;
    const idHolder = <div className="info">{id}</div>

    const handleToggleClick = () => {
        setIsOpen(!isOpen);
        if (!isOpen) {
            onToggleClick(id);
        }
    }

    useEffect(() => {
        if (id != expanded) {
            setIsOpen(false);
        }
    }, [expanded]);

    const toggleHolder = <img src={toggle} className="toggle" onClick={handleToggleClick}/>;

    const bookItem = <div id={bookId} className="book-item">
        {idHolder}
        {nameHolder}
        {toggleHolder}
        {authorHolder}
    </div>;

    const peopleItems = people.map((p) => {
        return <PersonItem className="customer" name={p}/>;
    });

    const peopleHolder = isOpen && (<div className="people-holder">{peopleItems}</div>);

    const bookItemHolder = <div className={bookHolderId}>{bookItem}{peopleHolder}</div>;

    return bookItemHolder;
}