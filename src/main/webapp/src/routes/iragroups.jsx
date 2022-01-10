import 'bootstrap/dist/css/bootstrap.min.css';
import Tab from 'react-bootstrap/Tab';
import React from "react";
import {Col, Nav, Row} from "react-bootstrap";

class IRAGroups extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            iraGroups : []
        };
    }

    componentDidMount() {
        fetch('/iragroup')
            .then(res => res.json())
            .then((data) => {
                this.setState({ iraGroups: data });
            })
            .catch(console.log);
    }

    render() {
        return <div style={{ display: "flex" }}>
            <Tab.Container>
                <Row>
                    <Col>
                        <Nav variant="pills" className="flex-column">
                        {this.state.iraGroups.map(iraGroup => (
                            <Nav.Item>
                                <Nav.Link eventKey={iraGroup.id}>{iraGroup.groupName}</Nav.Link>
                            </Nav.Item>
                        ))}
                        </Nav>
                    </Col>
                    <Col>
                        <Tab.Content>
                            {this.state.iraGroups.map(iraGroup => (
                                <Tab.Pane eventKey={iraGroup.id}>{iraGroup.groupName}</Tab.Pane>
                            ))}
                        </Tab.Content>
                    </Col>
                </Row>
            </Tab.Container>
        </div>
    }
}

export default IRAGroups;