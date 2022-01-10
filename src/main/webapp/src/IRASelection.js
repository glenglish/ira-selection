import * as React from 'react';
import { Outlet, Link } from 'react-router-dom';
import {Button} from "react-bootstrap";

export default function IRASelection() {
    return (
        <div>
            <h1><Link to="">IRA Selection</Link></h1>
            <nav>
                <Link to="/iras"><Button variant="primary">All IRAs</Button></Link>{' '}
                <Link to="/iragroups"><Button variant="primary">IRA Groups</Button></Link>{' '}
                <Link to="/iraquiz"><Button variant="primary">IRA Quiz</Button></Link>
            </nav>
            <Outlet />
        </div>
    );
}
