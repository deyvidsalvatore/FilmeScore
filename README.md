[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![GPL License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

# 🎬 FilmeScore
Um serviço web que oferece avaliações de filmes de forma simples e prático.
## Sobre o projeto
O usuário escolhe um filme do catálogo para avaliar e escolhe o número de 1 à 5 informando seu e-mail.
### 1. Menu Principal
No menu principal o usuário irá ver o catálogo de filmes e irá escolher, nisso é possível ver quantos avaliaram e qual a média de avaliação média que o filme tem.
![print1](docs/print1.jpg)
### 2. Menu Principal (Páginado)
O menu principal é paginado por até 12 resultados por página, então se precisa escolher os demais deverá passar para a próxima página com outros 12.
![print2](docs/print2.jpg)
### 3. Ao selecionar um filme
Ao selecionar um filme você deverá informar seu e-mail e o número de estrelas que você quer colocar.
![print3](docs/print3.jpg)
### 4. Após avaliar
Após a ação é possível ver que a avaliação do filme é atualizado.
![print4](docs/print4.jpg)

## ⚙️ Dependências necessárias
* Java 21
* Node 20.10.0
## 🚀 Como rodar o projeto
### Terminal
#### Back-end (Spring Boot)
```
git clone https://github.com/deyvidsalvatore/FilmeScore.git
cd backend/
./mvnw.cmd spring-boot:run
```
#### Front-end (React)
```
cd ..
cd frontend/
npm install
npm start
```

## Endpoints
| Método | URI | O que faz? |
|----------|----------|----------|
| GET | ```/api/v1/filmes```| Retorna uma lista página de filmes |
| GET | ```/api/v1/filmes/{id}```| Retorna uma lista de filme com um id específico |
| PUT | ```/api/v1/score``` | Coloca a avaliação de forma |
### Exemplo do uso do PUT:
```json
{
    "filmeId": 1,
    "score": 5,
    "email": "algum@email.com"
}
```

## LICENÇA
[![GPL License][license-shield]][license-url]
<br>
Por favor consulte os termos de licença, clicando [aqui](LICENSE).


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/deyvidsalvatore/FilmeScore.svg?style=for-the-badge
[contributors-url]: https://github.com/deyvidsalvatore/FilmeScore
[forks-shield]:  https://img.shields.io/github/forks/deyvidsalvatore/FilmeScore.svg?style=for-the-badge
[forks-url]: https://github.com/deyvidsalvatore/FilmeScore
[stars-shield]: https://img.shields.io/github/stars/deyvidsalvatore/FilmeScore.svg?style=for-the-badge
[stars-url]: https://github.com/deyvidsalvatore/FilmeScore/stargazers
[issues-shield]: https://img.shields.io/github/issues/deyvidsalvatore/FilmeScore.svg?style=for-the-badge
[issues-url]: https://github.com/deyvidsalvatore/FilmeScore/issues
[license-shield]: https://img.shields.io/github/license/deyvidsalvatore/FilmeScore.svg?style=for-the-badge
[license-url]: https://github.com/deyvidsalvatore/FilmeScore/LICENSE.md
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/deyvidsantosdevops