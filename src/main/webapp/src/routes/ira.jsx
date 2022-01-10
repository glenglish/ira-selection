import React from "react";
import {useParams} from "react-router-dom";

export default function IRA () {
    const [ira, setIRA] = React.useState([]);
    let params = useParams();

    React.useEffect(function effectFunction() {
        fetch('/ira/' + params.iraId)
            .then(res => res.json())
            .then((data) => {
                setIRA(data);
                console.log('advisor available: ' + data.advisorAvailable);
            })
            .catch(console.log);
    }, []);

    return (<div>
        <h1>{ira.bankName}</h1>
        <div>{ira.description}</div>
        <div>{ira.minimumBalance}</div>
        <div>{ira.fees}</div>
        <div>{ira.easeOfUse}</div>
        <div>{ira.automated ? true.toString() : false.toString()}</div>
        <div>{ira.advisorAvailable ? true.toString() : false.toString()}</div>
    </div>);
}

/*
class IRA extends React.Component {
    constructor(props) {
        super(props);
        this.state = { iraId: params.iraId, ira: null }
    }

    componentDidMount() {
        fetch('/ira', {
            method: 'POST',
            body: JSON.stringify({id: this.state.iraId})
        })
            .then(res => res.json())
            .then((data) => {
                this.setState({ ira: data });
            })
            .catch(console.log);
    }

    render() {
        return (<div>
            <h1>{this.state.ira.bankName}</h1>
        </div>)
    }
}

export default IRA;
 */