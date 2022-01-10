import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import IRAs from "./routes/iras";
import IRAGroups from "./routes/iragroups";
import IRASelection from "./IRASelection";
import IRA from "./routes/ira";
import IRAGroup from "./routes/iragroup";
import Quiz from './routes/quiz';

const rootElement = document.getElementById('root');
ReactDOM.render(
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<IRASelection />} >
                <Route path="iras" element={<IRAs />}>
                    <Route path=":iraId" element={<IRA />} />
                </Route>
                <Route path="iragroups" element={<IRAGroups />}>
                    <Route path=":iraGroupId" element={<IRAGroup />} />
                </Route>
                <Route path="iraquiz" element={<Quiz />}/>
                <Route
                    path="*"
                    element={
                        <main style={{ padding: "1rem" }}>
                            <p>Invalid path!</p>
                        </main>
                    }
                />
            </Route>
        </Routes>
    </BrowserRouter>,
    rootElement
);