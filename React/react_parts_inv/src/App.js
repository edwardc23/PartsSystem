import React from 'react';
import logo from './logo.svg';
import './App.css';
import HeaderComponent from './components/general/HeaderComponent';
import FooterComponent from './components/general/FooterComponent';

function App() {
  return (
    <div className="App">
      <header className="header">
        <HeaderComponent>
          <div>

          </div>
        </HeaderComponent>
      </header>
      <div>
        <FooterComponent/>
      </div>
    </div>
  );
}

export default App;
