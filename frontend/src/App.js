import React, { useEffect, useState } from 'react';

function App() {
  const [message, setMessage] = useState('');
  const backendUrl = window._env_?.REACT_APP_BACKEND_URL ;
  useEffect(() => { 
    fetch(backendUrl) // L'URL du backend
      .then(response => response.json())
      .then(data => setMessage(data.message))
      .catch(error => console.error('Error fetching message:', error));
  }, [backendUrl]);

  return (
    <div>
      <h1>Hello, World!</h1>
      <p>Message from backend: {message}</p>
    </div>
  );
}

export default App;