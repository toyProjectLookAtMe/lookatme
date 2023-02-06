import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function FindUser(){
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async() => {
            const res = await axios.get('/api/jpaSearchAll');
            console.log(res.data);
            return res.data;
        }

        fetchData().then(res => setData(res));
    }, []);

    return (
        <div>

            <div>
                {data.map(d => (
                    <Link key={d.jpaNumber} to={`${d.jpaNumber}`}>{d.jpaText}</Link>
                ))}
            </div>
            )

        </div>
    )
}

export default FindUser;