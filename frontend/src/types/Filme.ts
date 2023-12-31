export type Filme = {
    id: number;
    titulo: string;
    score: number;
    contador: number;
    imagem: string;
}

export type FilmePage = {
    content: Filme[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
    first: boolean;
    numberOfElements: number;
    empty: boolean;
}