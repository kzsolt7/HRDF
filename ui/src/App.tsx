import { useState } from 'react';
import './App.css'

function App() {
  const [inputValue, setInputValue] = useState('');
  const [formattedTime, setFormattedTime] = useState('');

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setInputValue(e.target.value);
  };

  const handleSubmit = async () => {
    if (!isNaN(Number(inputValue)) && inputValue.trim() !== '') {
      try {
        const response = await fetch(`http://localhost:8080/api/v1/time/format?seconds=${inputValue}`, {
          method: 'POST',
        });
        if (response.ok) {
          const data = await response.text();
          setFormattedTime(data);
        } else {
          setFormattedTime('Error: Unable to fetch formatted time');
        }
      } catch (error) {
        setFormattedTime('Error: Network issue');
      }
    } else {
      setFormattedTime('Please enter a valid number');
    }
  };

  return (
    <>
      <h1>Human readable duration formatter</h1>
      <div className="card">
        <input
          style={{
            width: '100%',
            padding: '10px',
            fontSize: '16px',
            border: '1px solid #ccc',
            borderRadius: '4px',
            marginBottom: '10px',
          }}
          type="number"
          placeholder="Enter seconds"
          value={inputValue}
          onChange={handleInputChange}
        />
        <button onClick={handleSubmit}>Format Time</button>
        <p>{formattedTime}</p>
      </div>
    </>
  )
}

export default App
