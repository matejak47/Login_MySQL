import { useState } from 'react';
import '../Dashboard.css';

export default function Dashboard() {
    const [appointmentDate, setDate] = useState('');
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');
    const [time, setTime] = useState('');

    const handleSave = async () => {
        try {
            await fetch('http://localhost:8080/api/customers', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                },
                body: JSON.stringify({
                    appointment_date: appointmentDate,
                    time: time,
                    name,
                    phone
                })
            });
            alert("Zákazník uložen");
        } catch (e) {
            alert("Chyba při ukládání");
        }
    };

    const logout = () => {
        localStorage.removeItem('token');
        window.location.href = '/';
    };

    return (
        <div className="dashboard-container">
            <div className="dashboard-box">
                <h2>Dashboard</h2>
                <input
                    type="date"
                    value={appointmentDate}
                    onChange={(e) => setDate(e.target.value)}
                />
                <input
                    type="time"
                    value={time}
                    onChange={(e) => setTime(e.target.value)}
                />
                <input
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    placeholder="Jméno"
                />
                <input
                    value={phone}
                    onChange={(e) => setPhone(e.target.value)}
                    placeholder="Telefon"
                />
                <button onClick={handleSave}>Uložit</button>
                <button onClick={logout} className="logout">Odhlásit</button>
            </div>
        </div>
    );
}
