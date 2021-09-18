import React from 'react';
import {useHistory} from 'react-router-dom';

const BookAdd = (props) => {

    const history = useHistory();
    const [book, updateBook] = React.useState({
        name: "",
        category: 0,
        authorid: 15,
        availableCopies: 0
    })

    const handleChange = (e) => {
        updateBook({
            ...book,
            [e.target.name]: e.target.value.trim()
        })
    }


    const onFormSubmit = (e) => {
        e.preventDefault();
        props.onAddBook(book.name, book.category, book.authorid, book.availableCopies);
        history.push("/books");
    }


    return(
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
                               placeholder="Enter book name"
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((category) =>
                                <option value={props.categories.indexOf(category)}>{category}</option>
                            )}
                        </select>
                    </div>

                    <div className="form-group">
                        <label>Authors</label>
                        <select name="authors" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) =>
                                <option value={term.id}>{term.name + " " + term.surname}</option>
                            )}
                        </select>
                    </div>


                    <div className="form-group">
                        <label htmlFor="name">Available copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               required
                               placeholder="Available copies"
                               onChange={handleChange}
                        />
                    </div>

                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default BookAdd;