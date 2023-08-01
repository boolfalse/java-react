
import { Form, Button } from 'react-bootstrap';

const ReviewForm = ({ handleSubmit, reviewInput, labelText, defaultValue }) => {
    return (
        <Form>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>{labelText}</Form.Label>
                <Form.Control ref={reviewInput} as="textarea" rows={3} defaultValue={defaultValue} />
            </Form.Group>
            <Button variant="outline-info" onClick={handleSubmit}>Submit</Button>
        </Form>
    )
}

export default ReviewForm
