import React from 'react'

function ButtonLink({ link, className, children }) {
  return (
    <a href={link} className={className}>
      {children}
    </a>
  );
}

export default ButtonLink;
