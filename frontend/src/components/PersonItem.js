import React from "react";
import "../styles/PersonItem.css";

export default function PersonItem(props) {
    const name = props.name;

    return (
        <div 
        id='customer'>
            {name}
        </div>
    );
}