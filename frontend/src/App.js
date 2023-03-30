import logo from './logo.svg';
import './App.css';
import ResultHolder from './components/ResultHolder';
import { useState } from 'react';

function App() {
  const [data, setData] = useState(null);

  const handleButtonClick = async () => {

  }

  return (
    <div className="App">
      <button
      id='action-btn'
      onClick={handleButtonClick}>
        Get country:
      </button>
      <ResultHolder data={data}/>
    </div>
  );
}

export default App;
