import logo from './logo.svg';
import './App.css';
import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <div> 
      <CalculateScore Name={"Steeve"}
    School={"ABC High School"}
    total={284}
    goal={5}/>
    </div>
  );
}

export default App;
