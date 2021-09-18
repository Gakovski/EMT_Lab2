import axios from '../custom-axios/axios';

const LibraryService = {
    fetchBooks: () => {
    return axios.get("/books");
    },

    fetchCategories: () => {
        return axios.get("/categories");
    },

    fetchAuthors: () => {
        return axios.get("/authors");
    },

    fetchCountries: ()=> {
        return axios.get("/countries");
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`)
    },

    rentBook: (id) => {
        return axios.delete(`/books/rent/${id}`)
    },

    addBook: (name, category, authorid, availableCopies) => {
        return axios.post("/books/add", {
            "name": name,
            "category": category,
            "authorid": authorid,
            "availableCopies": availableCopies
        })
    },

    editBook:(id, name, category, authorid, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "id": id,
            "name" : name,
            "category" : category,
            "authorid" : authorid,
            "availableCopies" : availableCopies
        });
    },

    getBook: (id) => {
        return axios.get(`/books/${id}`)
    }
}


export default LibraryService;