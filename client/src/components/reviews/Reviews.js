
import {useEffect, useRef, useState} from 'react';
import axiosConfig from '../../api/axiosConfig';
import {useParams} from 'react-router-dom';
import { Container, Row, Col } from 'react-bootstrap';
import ReviewForm from '../reviewForm/ReviewForm';

import React from 'react'
import api from "../../api/axiosConfig";

const Reviews = () => {
    const [movie, setMovie] = useState(null);
    const [reviews, setReviews] = useState([]);

    const reviewInput = useRef();
    let params = useParams();
    const imdbId = params.imdbId;

    const getMovieData = async (imdbId) => {
        try {
            const response = await api.get(`/movies/${imdbId}`);
            const movie = response.data;

            setMovie(movie);
            setReviews(movie.reviewIds);
        } catch (error) {
            console.log(error);
        }
    }

    useEffect(() => {
        getMovieData(imdbId);
    }, [])

    const addReview = async (e) => {
        e.preventDefault();
        const review = reviewInput.current.value;
        if (!review) {
            console.log("Please fill the form!");
        }

        try {
            const response = await axiosConfig.post("/reviews", {
                imdbId: imdbId,
                body: review,
            });
            reviewInput.current.value = "";

            setReviews([
                ...reviews,
                {
                    imdbId,
                    body: review,
                }
            ]);
        } catch(err) {
            console.error(err);
        }
    }

    return (
        <Container>
            <Row>
                <Col>
                    { movie ? movie.title : <h3>Reviews</h3> }
                </Col>
            </Row>
            {
                movie && <Row className="mt-2">
                    <Col>
                        <img src={movie?.poster} alt="" />
                    </Col>
                    <Col>
                        <Row>
                            <Col>
                                <ReviewForm handleSubmit={addReview}
                                            reviewInput={reviewInput}
                                            labelText="Write a Review?" />
                            </Col>
                        </Row>
                        <hr />
                        {
                            reviews ? reviews.map((rev, index) => {
                                return(
                                    <div key={index}>
                                        <Row className="mt-2">
                                            <Col>{rev.body}</Col>
                                        </Row>
                                        <hr />
                                    </div>
                                )
                            }) : <p>No Review yet!</p>
                        }
                    </Col>
                </Row>
            }
        </Container>
    )
}

export default Reviews
