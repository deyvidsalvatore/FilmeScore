import FilmeStars from "../FilmeStars/FilmeStars";

type Props = {
    score: number;
    contador: number;
}

function FilmeScore({score, contador} : Props) {
    return (
        <div className="filme-score-container">
            <p className="filme-score-value">{score > 0 ? score.toFixed(1) : '-'}</p>
            <FilmeStars score = {score} />
            <p className="filme-score-count">{contador} avaliações</p>
        </div>
    );
}

export default FilmeScore;