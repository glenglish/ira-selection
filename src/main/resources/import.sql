insert into ira values (nextval('ira_seq'), true, 'Vanguard 2k21', 'A Vanguard IRA', 1, 0.25, false, 100.00);
insert into ira values (nextval('ira_seq'), true, 'Fidelity', 'A Fidelity IRA', 1, 0.20, true, 200.00);
insert into ira values (nextval('ira_seq'), true, 'IRA Bank', 'An IRA Bank IRA', 2, 0.00, false, 300.00);
insert into ira values (nextval('ira_seq'), true, 'FIDELITY Legacy', 'A Fidelity IRA', 2, 0.15, true, 400.00);
insert into ira values (nextval('ira_seq'), true, 'ETrade', 'An ETrade IRA', 3, 0.10, false, 500.00);
insert into ira values (nextval('ira_seq'), false, 'JP Morgan', 'A JP Morgan IRA', 3, 0.05, true, 600.00);
insert into ira values (nextval('ira_seq'), false, 'Goldman Sachs', 'A Goldman Sachs IRA', 4, 0.30, false, 700.00);
insert into ira values (nextval('ira_seq'), false, 'SOFI', 'A SOFI IRA', 4, 2.25, true, 800);
insert into ira values (nextval('ira_seq'), false, 'Betterment', 'A Betterment IRA', 5, 1.50, false, 900.00);
insert into ira values (nextval('ira_seq'), false, 'Wells Fargo', 'A Wells Fargo IRA', 5, 1.75, true, 1000.00);

insert into iragroup values(nextval('iragroup_seq'),'Low Fees');
insert into iragroup values(nextval('iragroup_seq'), 'Easy To Use');
insert into iragroup values(nextval('iragroup_seq'), 'Low Balance');

insert into iragroupira (groupid, iraid) values(1, 1);
insert into iragroupira (groupid, iraid) values(1, 2);
insert into iragroupira (groupid, iraid) values(1, 3);
insert into iragroupira (groupid, iraid) values(1, 4);

insert into iragroupira (groupid, iraid) values(2, 5);
insert into iragroupira (groupid, iraid) values(2, 6);
insert into iragroupira (groupid, iraid) values(2, 7);
insert into iragroupira (groupid, iraid) values(2, 8);

insert into iragroupira (groupid, iraid) values(3, 9);
insert into iragroupira (groupid, iraid) values(3, 10);