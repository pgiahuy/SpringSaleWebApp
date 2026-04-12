import { useEffect, useState } from "react";
import API from "../configs/Apis";
import { Navbar, Nav, NavDropdown, Container } from "react-bootstrap";

const Header = () => {
    const [categories, setCategories] = useState([]);

    const loadCates = async () => {
        try {
            const res = await API.get("/categories");
            setCategories(res.data);
        } catch (err) {
            console.log(err);
        }
    };
    
    useEffect(() => {
        loadCates();
    }, []);

    return (
        <Navbar expand="lg" className="bg-info">
        <Container>
            <Navbar.Brand href="/">Trang chủ</Navbar.Brand>

            <Navbar.Toggle aria-controls="basic-navbar-nav" />

            <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">

                <NavDropdown title="Danh mục" id="basic-nav-dropdown">
                {categories.map((c, index) => (
                    <NavDropdown.Item key={index}>
                    {c.name}
                    </NavDropdown.Item>
                    
                ))}
                </NavDropdown>

            </Nav>
            </Navbar.Collapse>
        </Container>
        </Navbar>
    );
};

export default Header;