import React from 'react'
import { Link} from 'react-router-dom'
import {Container,Row,Col,OverlayTrigger,Tooltip} from 'react-bootstrap'
import Card  from '../../../components/Card'
import FindUser from '../../../api/testApi/findUser'

//img
import user01 from '../../../assets/images/user/01.jpg'
const apiTest = () => {
    return (
        <>
            <Container fluid>
                <Row>
                    <Col sm="12">
                        <Card>
                            <Card.Header className="d-flex justify-content-between">
                                <Card.Header.Title>
                                    <h4 className="card-title">User Lists</h4>
                                </Card.Header.Title>
                            </Card.Header>
                            <Card.Body>
                                <div className="table-view">
                                    <table className="data-tables table movie_table" style={{width:"100%"}}>
                                        <thead>
                                        <tr>
                                            <th style={{width: "10%"}}>Profile</th>
                                            <th style={{width: "10%"}}>Name</th>
                                            <th style={{width: "20%"}}>Contact</th>
                                            <th style={{width: "20%"}}>Email</th>
                                            <th style={{width: "10%"}}>Country</th>
                                            <th style={{width: "10%"}}>Status</th>
                                            <th style={{width: "10%"}}>Join Date</th>
                                            <th style={{width: "10%"}}>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>
                                                <img src={user01} className="img-fluid avatar-50" alt="author-profile"/>
                                            </td>
                                            <td>Anna Sthesia</td>
                                            <td>0123456789</td>
                                            <td>anna@gmail.com</td>
                                            <td>India</td>
                                            <td><span className="badge iq-bg-success">Active</span></td>
                                            <td>21 Jul, 2020</td>
                                            <td>
                                                <div className="flex align-items-center list-user-action">
                                                    <OverlayTrigger placement="top"overlay={<Tooltip>Edit</Tooltip>}>
                                                        <Link onClick={(e)=>e.preventDefault()} className="iq-bg-success" to="#"><i className="ri-pencil-line"></i></Link>
                                                    </OverlayTrigger>
                                                    <OverlayTrigger placement="top"overlay={<Tooltip>Delete</Tooltip>}>
                                                        <Link onClick={(e)=>e.preventDefault()} className="iq-bg-primary" to="#"><i className="ri-delete-bin-line"></i></Link>
                                                    </OverlayTrigger>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Container>
            <FindUser/>

        </>
    )
}
export default apiTest;