import { useEffect, useState } from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import API from "../../configs/Apis";
import { Col, Row } from "react-bootstrap";

const Home = () => {
    const [products, setProducts] = useState([]);

    const loadProducts = async () => {
        try {
            const res = await API.get("/products");
            setProducts(res.data);
        } catch (err) {
            console.log(err);
        }
    };

    useEffect(() => {
        loadProducts();
    }, []);

    return (
        <Row >{products.map((p, index) => (

            <Col xs={6} md={3} key={p.id} className="p-2">
                <Card>
                    <Card.Img className="p-4" variant="top" src={p.image || "https://cdn.tgdd.vn/Products/Images/42/342671/iphone-air-512gb-xanh-thumb-600x600.jpg"} />

                    <Card.Body>
                        <Card.Title>{p.name}</Card.Title>
                        <Card.Text>{p.price}</Card.Text>
                        <Card.Text>{p.description}</Card.Text>
                        <Card.Body>
                            <Button className="me-2" variant="danger">Đặt hàng</Button>
                            <Button variant="info">Xem chi tiết</Button>
                        </Card.Body>

                    </Card.Body>
                </Card>
            </Col>


        ))}

            <div className="text-center mb-2 mt-3">
                <Button variant="success" >Xem thêm...</Button>
            </div>
        </Row>

    );
};

export default Home;