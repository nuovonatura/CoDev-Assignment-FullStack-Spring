import React, { useState } from "react";
import "../styles/ResultHolder.css"

export default function ResultHolder(props) {
    let data = props.data;

    if (data == null) {
        const errorMessage = (<div id="error-message">No data found</div>);
        return (<div className="container">{errorMessage}</div>)
    }
}