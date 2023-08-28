const postForm = document.getElementById('postForm');
const postList = document.getElementById('postList');
const fetchButton = document.getElementById('fetchButton');

// Função para mostrar as postagens na lista
function showPosts(posts) {
    postList.innerHTML = '';
    posts.forEach(postagem => {
        const li = document.createElement('li');
        li.innerHTML = `
            <h2>${postagem.idPostagem}</h3>
            <h3>${postagem.tituloPostagem}</h3>
            <p>${postagem.subtituloPostagem}</p>
            <p>${postagem.descricaoPostagem}</p>
            <p>Data: ${postagem.dataPost}</p>
            <img src="data:image/jpeg;base64,${postagem.imagemPost}" alt="Imagem da Postagem">
        `;
        postList.appendChild(li);
    });
}

// Função para buscar as postagens da API
function fetchPosts() {
    fetch('http://localhost:8080/postagem/lista') // Atualize com a URL da sua API
        .then(response => response.json())
        .then(data => {
            showPosts(data);
        })
        .catch(error => {
            console.error('Erro na requisição:', error);
        });
}

// Evento de envio do formulário de postagem
postForm.addEventListener('submit', async event => {
    event.preventDefault();
    
    const idPostagem = document.getElementById('idPostagem').value;
    const tituloPostagem = document.getElementById('tituloPostagem').value;
    const subtituloPostagem = document.getElementById('subtituloPostagem').value;
    const descricaoPostagem = document.getElementById('descricaoPostagem').value;
    const dataPost = document.getElementById('dataPost').value;
    const imagemPost = document.getElementById('imagemPost');
    const imageFile = imagemPost.files[0];

    const formData = new FormData();
    formData.append('idPostagem', idPostagem);
    formData.append('tituloPostagem', tituloPostagem);
    formData.append('subtituloPostagem', subtituloPostagem);
    formData.append('descricaoPostagem', descricaoPostagem);
    formData.append('dataPost', dataPost);
    formData.append('imagemPost', imageFile);

    try {
        const response = await fetch('http://localhost:8080/postagem/salvar', {
            method: 'POST',
            body: formData,
        });

        if (response.ok) {
            console.log('Postagem enviada com sucesso!');
            fetchPosts(); // Atualize a lista após o envio
        } else {
            console.error('Erro ao enviar postagem.');
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
    }
});

// Evento de clique para buscar todas as postagens
fetchButton.addEventListener('click', () => {
    fetchPosts();
});
