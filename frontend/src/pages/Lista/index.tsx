import { useEffect, useState } from "react";
import { FilmePage } from "../../types/Filme";
import axios from "axios";
import { BASE_URL } from "../../utils/requests";
import Pagination from "../../components/Pagination/Pagination";
import FilmeCard from "../../components/FilmeCard/FilmeCard";

function Lista() {
    const [pageNumber, setPageNumber] = useState(0);
    const [page, setPage] = useState<FilmePage>({
      content: [],
      last: true,
      totalPages: 0,
      totalElements: 0,
      size: 12,
      number: 0,
      first: true,
      numberOfElements: 0,
      empty: true
    });
    
    useEffect(() => {
        axios.get(`${BASE_URL}/api/v1/filmes?size=12&page=${pageNumber}&sort=id`)
            .then(response => {
                const data = response.data as FilmePage;
                setPage(data);
            });
    }, [pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
      setPageNumber(newPageNumber);
    };

    return (
      <>
        <Pagination page={page} onChange={handlePageChange} />
        <div className="container">
          <div className="row">
            {page.content.map((filme) => (
              <div key={filme.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                <FilmeCard filme={filme} />
              </div>
            ))}
          </div>
        </div>
      </>
    );
}

export default Lista;