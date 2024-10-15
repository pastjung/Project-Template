import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)
  const [message, setMessage] = useState('')

  const springbootApiPort = import.meta.env.VITE_SPRINGBOOT_HOST_PORT;      // springboot port
  const springbootUrl = `http://localhost:${springbootApiPort}/api/hello`;  // springboot api 호출 URL

  const fastApiPort = import.meta.env.VITE_FASTAPI_HOST_PORT;      // fastapi port
  const fastAPIUrl = `http://localhost:${fastApiPort}/api/ping`;  // fastapi api 호출 URL

  const callSpringBoot = async () => {
    try {
      const response = await fetch(springbootUrl);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.text();
      setMessage(data);
    } catch (error) {
      setMessage('Error: ' + error.message);
    }
  };

  const callFastApi = async () => {
    try {
      const response = await fetch(fastAPIUrl);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.text();
      setMessage(data);
    } catch (error) {
      setMessage('Error: ' + error.message);
    }
  };

  return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <button onClick={callSpringBoot}>Call Spring Boot</button>
        <button onClick={callFastApi}>Call FastAPI</button>
        <p>{message}</p>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
