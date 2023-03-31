import logo from './logo.svg';
import './App.css';
import ResultHolder from './components/ResultHolder';
import { useState } from 'react';

function App() {
    const [data, setData] = useState(null);
    const [country_code, setCountryCode] = useState("null");

    const handleButtonClick = async () => {
        const response = await fetch('http://localhost:8080/getRandomCountry');
        const country = await response.json();
        setCountryCode(country.country.full_name);
        const response2 = await fetch('http://localhost:8080/getTop3ReadBooks?country_code=' + country.country.full_name);
        const data = await response2.json();
        setData(data);
    }

    return (
        <div className="App">
            <button
            id='action-btn'
            onClick={handleButtonClick}>
                Get country: {country_code}
            </button>
            <ResultHolder data={data}/>
        </div>
    );
}

export default App;
