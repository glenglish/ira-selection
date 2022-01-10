import { Outlet, Link } from "react-router-dom";
import React from "react";

class IRAs extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            iras : []
        };
    }

    componentDidMount() {
        fetch('/ira')
            .then(res => res.json())
            .then((data) => {
                this.setState({ iras: data });
            })
            .catch(console.log);
    }

    render() {
        return <div style={{ display: "flex" }}>
            <nav>
                {this.state.iras.map(ira => (
                    <Link
                        style={{ display: "block", margin: "1rem 0" }}
                        to={`/iras/${ira.id}`}
                        key={ira.id}
                    >
                        {ira.bankName}
                    </Link>
                ))}
            </nav>
            <Outlet />
        </div>
    }
}

export default IRAs;