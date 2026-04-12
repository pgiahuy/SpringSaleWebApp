import Alert from 'react-bootstrap/Alert';


const Footer = () =>{

    return (
        <>
          {[
            'primary',
          ].map((variant) => (
            <Alert key={variant} variant={variant}>
              Phan  Gia Huy &copy;  
            </Alert>
          ))}
        </>
      );
  }
  export default Footer




