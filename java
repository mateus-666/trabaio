// script.js
const generateBtn = document.getElementById('generate');
const exampleBtn = document.getElementById('example');
const promptEl = document.getElementById('prompt');
const resultEl = document.getElementById('result');


exampleBtn.addEventListener('click',()=>{
promptEl.value = 'Democratizar acesso a recursos educacionais personalizados usando IA para comunidades remotas.';
});


generateBtn.addEventListener('click',async()=>{
const prompt = promptEl.value.trim();
if(!prompt){
resultEl.textContent = 'Por favor, escreva um objetivo ou tema.';
return;
}
resultEl.textContent = 'Gerando missão...';


try{
const resp = await fetch('/mission',{
method:'POST',
headers:{'Content-Type':'application/json'},
body:JSON.stringify({prompt})
});
if(!resp.ok) throw new Error('Erro no servidor');
const data = await resp.json();
resultEl.textContent = data.mission;
}catch(err){
resultEl.textContent = 'Falha ao gerar missão: '+err.message;
}
});
