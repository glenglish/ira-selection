import React from 'react';
import {Button, FormLabel} from "react-bootstrap";
import Form from 'react-bootstrap/Form'

class Quiz extends React.Component {
    constructor(props) {
        super(props);
        this.state = {automated: false, advisorAvailable: false, easeOfUseMin: 1,
            easeOfUseMax: 5, minBalance: 0, maxBalance: 9999, feesMin: 0, feesMax: 1}
        this.onSubmit = this.onSubmit.bind(this);
        this.onEaseOfUseChange = this.onEaseOfUseChange.bind(this);
        this.onFeesChange = this.onFeesChange.bind(this);
        this.onBalanceChange = this.onBalanceChange.bind(this);
        this.onAdvisorChange = this.onAdvisorChange.bind(this);
        this.onAutomatedChange = this.onAutomatedChange.bind(this);
    }

    onSubmit(e) {
        e.preventDefault();
        this.setState({submitted: 'yes'})

        fetch('/ira/search', {
            method: 'POST',
            body: JSON.stringify(this.state)
        } )
            .then(res => res.json())
            .then((data) => {
                this.setState({ iras: data });
            })
            .catch(console.log);
    }

    onAutomatedChange(event) {
        this.setState( {automated: event.target.checked });
    }

    onAdvisorChange(event) {
        this.setState( {advisorAvailable: event.target.checked });
    }

    onEaseOfUseChange(event) {
        this.setState( {easeOfUse: event.target.value });
    }

    onBalanceChange(event) {
        switch(event.target.value) {
            case "1":
                this.setState( {minBalance: 0, maxBalance: 999.99 });
                break;
            case "2":
                this.setState( {minBalance: 1000, maxBalance: 4999.99 });
                break;
            case "3":
                this.setState( {minBalance: 5000, maxBalance: 9999.99 });
                break;
            case "4":
                this.setState( {minBalance: 10000, maxBalance: 14999.99 });
                break;
            case "5":
                this.setState( {minBalance: 15000, maxBalance: 999999999.99 });
                break;
        }
    }

    onFeesChange(event) {

    }

    shouldComponentUpdate(nextProps, nextState, nextContext) {
        /*
        console.log('props: ' + JSON.stringify(nextProps));
        console.log('state: ' + JSON.stringify(nextState));
        */

        return true;
    }

    render() {
        return (<div>
            <Form>
                <Form.Group className="mb-3" controlId="formAutomated">
                    <Form.Check onChange={this.onAutomatedChange} type="checkbox" label="Do you want your IRA rollover to be automated?" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="formAdvisor">
                    <Form.Check onChange={this.onAdvisorChange} type="checkbox" label="Would you want help available from a financial advisor?" />
                </Form.Group>

                <Form.Group onChange={this.onEaseOfUseChange}>
                    <FormLabel style={{display: 'block'}}>How easy should the IRA be to use? (1 = Not easy, 5 = Easiest)</FormLabel>
                    <Form.Check inline label="1" value="1" name="group1" type="radio" id={`easeofuse-radio-1`} />
                    <Form.Check inline label="2" value="2" name="group1" type="radio" id={`easeofuse-radio-2`} />
                    <Form.Check inline defaultChecked label="3" value="3" name="group1" type="radio" id={`easeofuse-radio-3`}/>
                    <Form.Check inline name="group1" value="4" label="4" type="radio" id={`easeofuse-radio-3`} />
                    <Form.Check inline name="group1" value="5" label="5" type="radio" id={`easeofuse-radio-3`} />
                </Form.Group>

                <Form.Group>
                    <FormLabel>How much money is in your 401k?</FormLabel>
                    <Form.Select onChange={this.onBalanceChange} style={{width: 200}}>
                        <option value="1">Under $1,000.</option>
                        <option value="2">Under $5,000.</option>
                        <option value="3">Under $10,000.</option>
                        <option value="4">Under $15,000.</option>
                        <option value="5">Over $15,000.</option>
                    </Form.Select>
                </Form.Group>

                <Form.Group>
                    <FormLabel>What kind of fees would you not mind?</FormLabel>
                    <Form.Select onChange={this.onFeesChange} style={{width: 200}}>
                        <option value="1">None!</option>
                        <option value="2">Up to 1%</option>
                        <option value="3">Over 1% but less than 5%</option>
                    </Form.Select>
                </Form.Group>

                <Button variant="primary" type="submit" onClick={this.onSubmit}>
                    Submit
                </Button>
            </Form>
        </div>)
    }
}

export default Quiz;