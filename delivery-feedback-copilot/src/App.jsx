import { useState } from "react";
import "./App.css";

function App() {
  const [feedback, setFeedback] = useState("");
  const [resultado, setResultado] = useState("");

async function analisarFeedback() {
  if (feedback.trim() === "") {
    setResultado("Digite um feedback antes de analisar.");
    return;
  }

  try {
    const resposta = await fetch("http://localhost:8080/api/feedback", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        feedback: feedback,
      }),
    });

    if (!resposta.ok) {
      throw new Error("Erro ao enviar feedback.");
    }

    const dados = await resposta.json();

    setResultado(dados.mensagem);

  } catch (erro) {
    setResultado("Não foi possível conectar ao servidor.");
    console.error(erro);
  }
}

  return (
    <main>
      <h1>Delivery Feedback Copilot</h1>

      <p>
        Entenda seus feedbacks e descubra como melhorar a experiência dos seus
        clientes.
      </p>

      <textarea
        value={feedback}
        onChange={(event) => setFeedback(event.target.value)}
        placeholder="Digite o feedback do cliente..."
      />

      <button type="button" onClick={analisarFeedback}>
        Analisar feedback
      </button>

      {resultado && <p>{resultado}</p>}
    </main>
  );
}

export default App;
