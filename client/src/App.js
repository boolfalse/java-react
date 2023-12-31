
import './App.css';
import api from './api/axiosConfig';
import {useState, useEffect} from 'react';
import Layout from './components/Layout';
import { Routes, Route } from 'react-router-dom';
import Home from './components/home/Home';
import Header from './components/header/Header';
import Trailer from './components/trailer/Trailer';
import Reviews from './components/reviews/Reviews';
import NotFound from './components/notFound/NotFound';

function App() {

  const [movies, setMovies] = useState();

  const getMovies = async () => {
    try {
      const response = await api.get("/movies");
      setMovies(response.data);
    } catch(err) {
      console.error(err);
    }
  }

  useEffect(() => {
    getMovies();
  },[])

  return (
      <div className="App">
        <Header/>
        <Routes>
          <Route path="/" element={<Layout/>}>
            <Route path="/" element={<Home movies={movies} />} ></Route>
            <Route path="/trailer/:ytVideoId" element={<Trailer/>}></Route>
            <Route path="/reviews/:imdbId" element={<Reviews />}></Route>
            <Route path="*" element={<NotFound/>}></Route>
          </Route>
        </Routes>
      </div>
  );
}

export default App;