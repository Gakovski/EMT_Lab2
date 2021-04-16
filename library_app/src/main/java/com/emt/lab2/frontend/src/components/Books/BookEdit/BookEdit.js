import React from 'react';
import {useHistory} from 'react-router-dom';

const BookEdit = (props) => {

    const history = useHistory();
    const [updatedBook, updateBook] = React.useState({
        name: "",
        category: 0,
        author: 1,
        availableCopies: 0
    })

    const handleChange = (e) => {
        updateBook({
            ...updatedBook,
            [e.target.name]: e.target.value.trim()
        });
    }



    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = updatedBook.name;
        const category = props.categories[updatedBook.category];
        const author = props.authors.find((a) => a.id === parseInt(updatedBook.author));
        const availableCopies = updatedBook.availableCopies >= 0 ? updatedBook.availableCopies : props.book.availableCopies;
        props.onEditBook(props.book.id, name, category, author.id, availableCopies);
        history.push("/books");
    }


    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder={props.book.name}
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((category) =>
                                <option key={category} value={props.categories.indexOf(category)}>{category}</option>
                            )}
                        </select>
                    </div>

                    <div className="form-group">
                        <label>Authors</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) =>{
                                if(props.book.term !== undefined) {
                                    return <option key={term.id} selected={term.id}
                                                   value={term.id}>{term.name + " " + term.surname}</option>
                                }
                                else {
                                    return <option key={term.id} value={term.id}>{term.name + " " + term.surname}</option>
                                }
                            })}
                        </select>
                    </div>


                    <div className="form-group">
                        <label htmlFor="name">Available copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               required
                               placeholder={props.book.availableCopies}
                               onChange={handleChange}
                        />
                    </div>

                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default BookEdit;
