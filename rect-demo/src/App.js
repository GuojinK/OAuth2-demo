import logo from './logo.svg';
import './App.css';
import axios from 'axios';

function App() {

  const onClick = ()=>{
    const formData = new FormData()
    formData.append("username","test@test.com")
    formData.append("password","123")
    axios.post("http://localhost:8080/login",formData,{headers:{"content-type":"application/x-www-form-urlencoded"}})
  }

  const register = ()=>{
    const formData = new FormData()
    formData.append("email","test@test.com")
    formData.append("password","123")
    axios.get("http://localhost:8080/api/register",formData,{headers:{"content-type":"application/x-www-form-urlencoded"}})
  }

  const get = async ()=>{
   const res = await axios.get("http://localhost:8080")
    console.log(res.data);
  }
  return (
    <div className="App">
        <button onClick={onClick}>Login</button>
        <button onClick={register}>register</button>
        <button onClick={get}>get</button>

    </div>
  );
}

export default App;
