import { ReactComponent as Arrow } from '../../assets/arrow.svg'
import './Pagination.css'
import { FilmePage } from '../../types/Filme'

type Props = {
    page: FilmePage;
    onChange: Function;
}

function Pagination({ page, onChange}: Props) {
    return (
        <div className="filme-pagination-container">
            <div className="filme-pagination-box">
                <button className="filme-pagination-button" disabled={page.first} onClick={() => onChange(page.number - 1)}>
                    <Arrow />
                </button>
                <p>{`${page.number + 1} de ${page.totalPages}`}</p>
                <button className="filme-pagination-button" disabled={page.last} onClick={() => {
                    onChange(page.number + 1)
                }}>
                    <Arrow className='filme-flip-horizontal'/>
                </button>
            </div>
        </div>
    );
}

export default Pagination;