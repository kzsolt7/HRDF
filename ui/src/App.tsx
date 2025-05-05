import { useState } from 'react';
import './App.css'

function App() {
  const [inputValue, setInputValue] = useState('');
  const [formattedTime, setFormattedTime] = useState('');

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
          type="text"
          placeholder="Enter seconds"
          value={inputValue}
        />
        <button onClick={() => { }}>Format Time</button>
        <p>{formattedTime}</p>
      </div>
    </>
  )
}

export default App
