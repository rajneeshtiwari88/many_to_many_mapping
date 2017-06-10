
    alter table employee 
       drop 
       foreign key fk_emp_dpt;

    alter table employee 
       drop 
       foreign key fk_emp_profile;

    alter table employee_address 
       drop 
       foreign key fk_emp_address;

    alter table org_dpt 
       drop 
       foreign key fk_dpt_org;

    alter table org_dpt 
       drop 
       foreign key fk_org_dpt;

    drop table if exists department;

    drop table if exists employee;

    drop table if exists employee_address;

    drop table if exists employee_profile;

    drop table if exists org_dpt;

    drop table if exists organisation;

    create table department (
       id varchar(255) not null,
        dpt_code varchar(25),
        dpt_name varchar(25),
        dpt_skill varchar(25),
        primary key (id)
    );

    create table employee (
       id varchar(255) not null,
        emp_name varchar(25),
        emp_salary decimal(7,2),
        emp_dpt_id varchar(255),
        emp_profile_id varchar(255),
        primary key (id)
    );

    create table employee_address (
       id varchar(255) not null,
        area_name varchar(25),
        country varchar(25),
        first_line varchar(25),
        pincode integer,
        second_line varchar(25),
        state varchar(25),
        emp_address_id varchar(255),
        primary key (id)
    );

    create table employee_profile (
       id varchar(255) not null,
        emp_gender varchar(1),
        emp_qualfication varchar(25),
        primary key (id)
    );

    create table org_dpt (
       org_id varchar(255) not null,
        dpt_id varchar(255) not null,
        primary key (org_id, dpt_id)
    );

    create table organisation (
       id varchar(255) not null,
        org_code varchar(25),
        org_name varchar(25),
        org_strength integer,
        primary key (id)
    );

    alter table employee 
       add constraint fk_emp_dpt 
       foreign key (emp_dpt_id) 
       references department (id);

    alter table employee 
       add constraint fk_emp_profile 
       foreign key (emp_profile_id) 
       references employee_profile (id);

    alter table employee_address 
       add constraint fk_emp_address 
       foreign key (emp_address_id) 
       references employee (id);

    alter table org_dpt 
       add constraint fk_dpt_org 
       foreign key (dpt_id) 
       references department (id);

    alter table org_dpt 
       add constraint fk_org_dpt 
       foreign key (org_id) 
       references organisation (id);
